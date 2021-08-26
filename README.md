# Parser

Il Parser si occupa si analizzare una serie di lessemi e costatare che tale sequenza sia sintatticamente corretta (come previsto da grammatica implementata).
In particolare la grammatica implementata nel seguente Parser è costituita da espressioni algebriche semplici in notazione infissa.
L'esecuzione del Parser è composta da due azioni:
        - Inizialmente viene eseguito il Lexer il quale analizzerà dal punto di vista lessicale l'espressione andando a generare una sequanza di token corrispondente
        - Successivamente il Parser prenderà in input la sequenza di token e la analizzerà dal punto di vista sintattico andando a produrre un risultato
Gli esiti derivanti dall'esecuzione sono due:
        - Il programma ha rivelato un errore sintattico e si è arrestato nell'esatto punto dove l'errore è stato trovato
        - Il programma non ha rivelato errori sintattici e ha terminato l'esecuzione con la scritta "Ok!"
Per testare e provare il programma seguire i seguenti passaggi:
        - Assicurarsi di aver installato java virtual machine sul proprio computer
        - Scaricare tutti i file all'interno della directory principale del proprio dispositivo
        - Compilare tutti i file da terminale attraverso il comando "javac NomeFile.java" lasciando Parser.java per ultimo
        - Scrivere delle espressioni in notazione infissa all'interno del file "Prova.txt"
        - Eseguire Parser.java attraverso il comando "java Parser" grazie al quale si otterrà l'esito dell'analisi sintattica
Degli esempi accettati dal linguaggio potrebbero essere "4 + 2" oppure "(3 - 1) * 4".
