PASSO A PASSO PARA EXECUTAR O SISTEMA DE TUTORIA DE PARES

Obs: Essas instruções pressupõem que você já possui o MySQL instalado. Caso você ainda não o tenha em sua máquina, siga as instruções deste vídeo para instalá-lo: https://www.youtube.com/watch?v=lLXy2Shy9V8&t=179s&ab_channel=Prof.Rog%C3%A9rioNapole%C3%A3oJr.

PRIMEIRA PARTE: DOWNLOAD DOS ARQUIVOS NECESSÁRIOS

1°: Instale o IntelliJ através deste link: https://www.jetbrains.com/pt-br/idea/download/?section=windows

2°: Instale o Apache Tomcat através deste link: https://tomcat.apache.org/download-90.cgi

3°: Instale o MySQL Connector através deste link (escolha a opção "connector/j"): https://dev.mysql.com/downloads/

4°: Agora, com as instalações prontas, abra seu IntelliJ.

5°: Vá no canto superior esquerdo, clique em "File", depois clique em "Open" e abra o diretório da Tutoria de Pares no IntelliJ.


SEGUNDA PARTE: CONECTANDO OS ARQUIVOS COM O INTELLIJ

1°: Siga as instruções desse vídeo para conectar o MySQL Connector no IntelliJ: https://www.youtube.com/watch?v=V2bGKzvMQyc&ab_channel=BoostMyTool (embora o vídeo esteja em inglês, não é necessário compreender o que ele está falando. Apenas reproduza os passos).

2°: Para conectar o Apache com o IntelliJ, siga todas as instruções desse vídeo do 1:00 até o 3:47: https://www.youtube.com/watch?v=iTzauISg5P4&t=215s&ab_channel=VytasGadliauskas

3°: Para conectar o iTextPdf com o IntelliJ, assista esse vídeo do início até o 0:33: https://www.youtube.com/watch?v=LWqduyt1ck0&ab_channel=CodeOpsTech

4°: Agora, vá até o pacote em que as classes controller estão localizadas. Se o IntelliJ não reconhecer o servlet mesmo após as conexões, vá nas importações de cada classe (elas ficam no topo do código) e substitua a palavra "jakarta" por "javax" ou vice-versa. Faça isso com todas as classes Controller.

5°: Acesse o nosso arquivo .txt de nome "sql" e crie tanto o banco de dados quanto as tabelas necessárias.

6°: Direcione-se até a classe "ConnectionDB" que está localizada no pacote "dao". Lá, substitua o driver, o URL, o usuário e a senha para que fiquem de acordo com o MySQL do seu computador.


TERCEIRA ETAPA: EXECUTAR O CÓDIGO:

1°: Se, ao executar, o IntelliJ ainda apresentar erro, o problema pode estar na sua versão do JDK. Altere-o para a versão que o IntelliJ sugerir.


