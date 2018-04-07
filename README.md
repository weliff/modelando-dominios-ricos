# modelando-dominios-ricos
Modelando Dominios Ricos

1. Linguagem ubiqua: O cliente, time, domain experts, software... TODOS! Devem falar a mesma linguagem e os mermos jargões. 
  O código deve refletir a linguagem utilizada. Traga tudo que for capturado nas conversas para o software. Caso utilize código 
    em inglês, se não tiver tradudção apropriada, utilize o termo em português como o cliente falou.

2. Dominios Ricos vs Dominios Anemicos: Dominios ricos são mais fáceis de testar, reutilizar, entender 
  e concentrar regras de dominio. Dominios Anemicos sao tendenciosos a ter apenas uma estrutura que reflete 
  o repositorio de dados, dificulta a escrita de testes.

3. Sub-dominios: Possivel dividir um dominio em dominios menores.

4. Separação e Contextos Delimitados: A separação do dominio reflete um contexto. Uma mesma entidade pode estar presente em dois
  sub-dominios, mas com significados diferentes para o contexto em que apresenta. Ex: Cliente, em um contexto departamento financeiro 
  o cliente é a pessoa que recebe dinheiro, já no contexto de vendas é a pessoa que paga!
 
5. Entidades: Representa artefatos do negócio que possuem uma identificação única no contexto.
 
6. Corrupção no Código: Sempre que possível proteja o dominio de ser corrompido. Não permita que as regras de negócio sejam 
  puladas. 

7. Primitive Obsession: Reduz o reuso, utilize VOs para melhorar a utilização de regras de valores de dominio.

8. Value Objects: Fazem parte da entidade, representam valores e não tem uma identificão única no contexto. 
  Não são gerenciados sem sozinhos ou sem uma entidade.

