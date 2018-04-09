package br.com.handle;

import br.com.command.CommandResult;
import br.com.command.CreatePayPalSubscriptionCommand;
import br.com.command.GenericCommandResult;
import br.com.entity.PayPalPayment;
import br.com.entity.Student;
import br.com.entity.Subscription;
import br.com.repository.StudentRepository;
import br.com.service.EmailService;
import br.com.vo.*;
import lombok.experimental.var;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.time.LocalDate;


public class SubscriptionHandler implements Handler<CreatePayPalSubscriptionCommand> {

    private StudentRepository studentRepository;

    private EmailService emailService;

    BindingResult bindingResult;

    public SubscriptionHandler(StudentRepository studentRepository, EmailService emailService) {
        this.studentRepository = studentRepository;
        this.emailService = emailService;

        DataBinder dataBinder = new DataBinder(this);
        bindingResult = dataBinder.getBindingResult();
    }

    @Override
    public GenericCommandResult handle(CreatePayPalSubscriptionCommand command) {
        // Verificar se Documento já está cadastrado
        if (studentRepository.documentExists(command.document))
            bindingResult.rejectValue("document", null, "Este CPF já está em uso");

        // Verificar se E-mail já está cadastrado
        if (studentRepository.emailExists(command.email))
            bindingResult.rejectValue("email", null, "Este E-mail já está em uso");

        // Gerar os VOs
        Name name = new Name(command.firstName, command.lastName);
        Document document = new Document(command.document, DocumentType.CPF);
        Email email = new Email(command.email);
        Address address = new Address(command.street, command.number, command.neighborhood, command.city, command.state,
                command.country, command.zipCode);

        // Gerar as Entidades
        Student student = new Student(name, document, email);
        Subscription subscription = new Subscription(LocalDate.now().plusDays(30));

        // Só muda a implementação do Pagamento
        var payment = new PayPalPayment(
                command.paidDate,
                command.expireDate,
                command.total,
                command.totalPaid,
                command.payer,
                new Document(command.payerDocument, command.payerDocumentType),
                address,
                email,
                command.transactionCode
        );

        // Relacionamentos
        subscription.addPayment(payment);
        student.addSubscription(subscription);

        // Agrupar as Validações
//        bindingResult.
//        AddNotifications(name, document, email, address, student, subscription, payment);

        // Salvar as Informações
        studentRepository.createSubscription(student);

        // Enviar E-mail de boas vindas
        emailService.send(student.getName().toString(), student.getEmail().getAddress(), "bem vindo ao balta.io", "Sua assinatura foi criada");

        // Retornar informações
        return new GenericCommandResult(true, "Assinatura realizada com sucesso");
    }
}
