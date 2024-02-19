### PASSO A PASSO PARA EXECUTAR A SISTEMA DE TUTORIA DE PARES ###

Obs: Essas instruções pressupõem que você já possui o MySql instalado. Caso você ainda não o tenha em sua máquina, siga as instruções deste vídeo para instalá-lo: https://www.youtube.com/watch?v=lLXy2Shy9V8&t=179s&ab_channel=Prof.Rog%C3%A9rioNapole%C3%A3oJr.


PRIMEIRA PARTE: DOWNLOAD DOS ARQUIVOS NECESSÁRIOS

1°: Instale o Intelij através deste link: https://www.jetbrains.com/pt-br/idea/download/?section=windows

2°: Instale o apache tomcat através deste link: https://tomcat.apache.org/download-90.cgi

3°: Instale o MySql Connector através deste link (escolha a opção "connector/j"): https://dev.mysql.com/downloads/

4°: Agora com as instalações prontas, abra seu Intelij

5°: Vá no canto superior esquerdo, clique o "File", depoís clique em "Open" e abra o diretório da Tutoria de Pares no Intelij


SEGUNDA PARTE: CONECTANDO OS ARQUIVOS COM O INTELIJ

1°: Siga as instruções desse vídeo para conectar o MySql connector no INtelij: https://www.youtube.com/watch?v=V2bGKzvMQyc&ab_channel=BoostMyTool (embora o vídeo esteja em inglês, não é necessário compreender o que ele está falando. Apenas reproduza os passos)

2°: Para conectar o apoache com o Intelij, siga todas as instruções desse vídeo do 1:00 até o 3:47: https://www.youtube.com/watch?v=iTzauISg5P4&t=215s&ab_channel=VytasGadliauskas

3°: Para conectar o ItextPdf com o Intelij, assista esse vídeo início até o 0:33: https://www.youtube.com/watch?v=LWqduyt1ck0&ab_channel=CodeOpsTech

3°: Agora, vá até o pacote em que as classes controller estão locazliadas. Se o Intelij não reconhecer o servlet mesmo após as conexões, vá nas importações de cada classe (elas ficam no topo do código) e substitua a palavra "jakarta" por "javax" ou vice-versa. 
Faça isso com todas as classes Controller.

4°: Acesse o nosso arquivo .txt de nome "sql" e crie tanto o banco de dados quanto as tabelas necessárias. 

5°: Direcione-se até a classe "ConnectionDB" que está localizada no pacote "dao". Lá, substitua o driver, o url, o user e a password para que fiquem de acordo com o MySql do seu computador.

TERCEIRA ETAPA: EXECUTAR O CÓDIGO:

1°: Se, ao executar, o Intelij ainda apresentar erro, o problema pode estar na sua versão do JDK. Altere-o para a versão que o Intelij sugerir. 



