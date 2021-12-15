# Progetto-OOP-Gennaio-2022
# CurrencyLayer App
L'applicazione nasce con l'obiettivo di fornire uno strumento tecnico che possa essere di aiuto a qualsiasi economista e investitore interessato nel **Forex**, il mercato delle valute, che rappresenta il mercato più grande al mondo in termini di valori delle transazioni e di liquidità (per sua stessa natura).
# Descrizione
L'applicazione utilizza i dati ricevuti dall'API Currency Layer, che fornisce informazioni in tempo reale sul valore di più di 160 valute in tutto il mondo, inclusi due metalli preziosi, rispetto al dollaro statunitense. 
**Una lista di tutte le valute supportate con il relativo codice identificativo (tre lettere in maiuscolo) da inserire nell'app è disponibile al seguente link: https://currencylayer.com/currencies .**

Inoltre è possibile effettuare un analisi storica richiedendo all'API il valore storico di una valuta rispetto al dollaro in un qualsiasi giorno nell'arco di tempo che va dal 1990 ad oggi.
A partire dai dati ricevuti si possono effettuare statistiche sull'andamento di un insieme di valute inserite in input, nei diversi mesi o anni dell'analisi storica, sempre rispetto all'USD.
# PLUS DELL'APPLICAZIONE
1 * TASSO DI CAMBIO IN TEMPO REALE SU UN SET DI VALUTE RISPETTO ALL'USD.
2 * TASSO DI CAMBIO STORICO RIFERITO A UN GIORNO SCELTO DALL'UTENTE SU UN SET DI VALUTE RISPETTO ALL'USD.
3 * STATISTICHE ANNUALI
4 * STATISTICHE SULLO STESSO MESE IN DIVERSI ANNI PER VALUTARE IL MIGLIOR PERIODO DI INVESTIMENTO
5 * CONVERTITORE DI VALUTA IN EURO CON RIFERIMENTO AL TASSO DI CAMBIO STORICO NEL GIORNO INDICATO DALL'UTENTE.
# AVVERTENZE
Il programma è stato realizzato per un progetto d'esame universitario e sfrutta il pacchetto gratuito dell'API Currency Layer. Questo pacchetto permette all'utente di richiedere informazioni solamente su un singolo giorno, e non su un lasso di tempo entro due date (funzione a pagamento).
Per questo motivo per testare comunque le funzioni di filtri e statistiche l'applicazione sfrutta un file incluso nella directory del programma **"quotes.list.txt**, dove sono stati salvati dati relativi al valore di 3 valute: EUR,GBP,BTC
nei 12 mesi degli ultimi 3 anni: 2019,2020,2021.
L'utente che fosse interessato ad ottenere un servizio completo può liberamente acquistare la versione a pagamento dell'API ed effettuare una lieve modifica al codice, che invece di andare a leggere da file locale i dati per il calcolo delle statistiche andrebbe a chiederli direttamente all'API come fa già per i punti 1 e 2 dei PLUS DELL'APPLICAZIONE.
