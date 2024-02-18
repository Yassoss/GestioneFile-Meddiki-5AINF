## Gestione File - Java

Questo progetto Java fornisce un'applicazione di gestione di file che include lettura da un file "user.json", interazione con l'utente attraverso la console, e scrittura di dati su diversi file in modo asincrono utilizzando i thread.

### Contenuto del Progetto

1. **GestioneFile.java**

   - **Compito:** la classe principale che coordina l'interazione con l'utente, la lettura e la scrittura dei file.
   
   - **Rapporto con altre classi:** utilizza oggetti delle classi `Lettore` e `Scrittore` per gestire rispettivamente la lettura e la scrittura dei file. Interagisce con l'utente attraverso la classe `Scanner`.

2. **Lettore.java**

   - **Compito:** una classe che estende `Thread` per leggere il contenuto di un file specificato.
   
   - **Rapporto con altre classi:** è utilizzata da `GestioneFile.java` per leggere il file "user.json". Viene avviata come un thread separato per eseguire la lettura in modo asincrono.

3. **Scrittore.java**

   - **Compito:** una classe che implementa `Runnable` per scrivere i dati dell'utente su un file specificato utilizzando la classe `BufferedWriter`.
   
   - **Rapporto con altre classi:** è utilizzata da `GestioneFile.java` per scrivere i dati dell'utente su tre file diversi ("output.csv", "copia.csv", "user.csv"). Viene eseguita come un thread separato per eseguire la scrittura in modo asincrono.


### Funzionamento

1. **LETTURA (1):**
   - Viene creato un oggetto `Lettore` per leggere il file "user.json". Questo avviene in modo asincrono attraverso l'avvio di un thread dedicato.

2. **ELABORAZIONE (2):**
   - L'utente inserisce un nome utente e una password tramite la console utilizzando la classe `Scanner`.

3. **SCRITTURA (3):**
   - Vengono creati tre oggetti `Scrittore` per scrivere dati su file in modo asincrono. Viene utilizzato un thread per la scrittura continua su "user.csv".
   - Viene anche registrato il nome del file "user.csv" attraverso un oggetto `DataOutputStream`.

### Esecuzione

Per eseguire il programma, avviare il file principale `GestioneFile.java` e seguire le istruzioni nella console per inserire il nome utente e la password.


### Autore

Meddiki Yassine - 18/02/24
