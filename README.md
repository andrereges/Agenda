# Agenda

Aplicação desktop feita em java-11-openjdk-amd64 feita usando a IDE eclipse 

Class main localizada em br.com.agenda.Agenda

Criado formulário usando o pacote javax.swing para componentes gráficos

Feita a divisão de pacotes para melhor organização do projeto, cada pacote com as classes com mesma finalizadade

Funções da Agenda
- Cadastro eventos com os atributos descrição, data, encaminhar e-mail, periodicidade e alarme
- Aba Cadastro - Com as funções de salvar, limpar formulário
- Aba Lista - Com a função de listar eventos em uma tabela
- A função encaminhar e-mail e alarme é só cadastro não tem ação implementada
- Os registros são salvos em um arquivo de texto chamado eventos.txt localizada na raiz do projeto
- O arquivo eventos.txt é criado quando o aplicativo é executado a primeira vez

Como rodar a aplicação

- O arquivo .jar estará na raiz do projeto para testar
- Certifique se que seu sistema operacional esteja rodando o java na versão java-11-openjdk-amd64
- Dê as permissões de execução no arquivo Agenda.jar
- Depois execute o app pelo comando: java -jar agenda.jar ou clique duas vezes no arquivo

