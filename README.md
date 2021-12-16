# Progetto-OOP-Gennaio-2022
# CurrencyLayer App
L'applicazione nasce con l'obiettivo di fornire uno strumento tecnico che possa essere di aiuto a qualsiasi economista e investitore interessato nel **Forex**, il mercato delle valute, che rappresenta il mercato più grande al mondo in termini di valori delle transazioni e di liquidità (per sua stessa natura).
# Contenuti :

* [Descrizione](#intro)
* [Funzioni dell'applicazione](#plus)
* [Rotte](#rotte)
* [Parametri](#param)
* [Formato restituto](#form)
* [Eccezioni](#eccez)
* [Test](#test)
* [Documentazione](#doc)
* [Autori](#autor)

<a name="intro"></a>
## Descrizione 

L'applicazione utilizza i dati ricevuti dall'API Currency Layer, che fornisce informazioni aggiornate quotidianamente sul valore di più di 160 valute in tutto il mondo, inclusi due metalli preziosi, rispetto al dollaro statunitense. 
**Una lista di tutte le valute supportate con il relativo codice identificativo (tre lettere in maiuscolo) da inserire nell'app è disponibile al seguente link: https://currencylayer.com/currencies .**

L'utente può effettuare un analisi storica richiedendo all'API il valore del tasso di cambio di una valuta rispetto al dollaro in un qualsiasi giorno nell'arco di tempo che va dal 1990 ad oggi.
A partire dai dati ricevuti si possono effettuare statistiche sull'andamento di un insieme di valute inserite in input, nei diversi mesi o anni dell'analisi storica, sempre rispetto all'USD (dollaro statunitense).
<a name="plus"></a>
## Funzioni 
* **Tasso di cambio storico**
* riferito a un giorno a scelta dell'utente dal 1990 ad oggi, su un set di valute scelto dall'utente rispetto all'USD
* **Convertitore in euro**
* di un qualsiasi ammontare di una certa valuta in un giorno scelto dall'utente con riferimento al tasso storico relativo a quel giorno.
* **Statistiche annuali**
* Media,varianza e scostamento medio del valore in dollari di un set di valute all'interno di un anno solare.
* **Statistiche mensili**
* Media,varianza e scostamento medio del valore in dollari di un set di valute nello stesso mese di diversi anni, per valutare il miglior periodo di investimento.

# Avvertenze :warning:
Il programma è stato realizzato per un progetto d'esame universitario e sfrutta il pacchetto gratuito dell'API Currency Layer. Questo pacchetto permette all'utente di richiedere informazioni solamente su un singolo giorno, e non su un lasso di tempo entro due date (funzione a pagamento).
Per questo motivo per provare il funzionamento delle statistiche su periodi estesi l'applicazione sfrutta un file incluso nella directory del programma **"quotes.list.txt**, dove sono stati salvati dati relativi al valore di 3 valute: *EUR,GBP,BTC* 
nei 12 mesi degli ultimi 3 anni: *2019,2020,2021*.
L'utente che fosse interessato ad ottenere un servizio completo può liberamente acquistare la versione a pagamento dell'API ed effettuare una lieve modifica al codice, che invece di andare a leggere da file locale i dati per il calcolo delle statistiche andrebbe a chiederli direttamente all'API come fa già per le funzioni gratuite.

<a name="rotte"></a>
## Rotte 
Le richieste vanno effettuate all'indirizzo http://localhost:8080
N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/exhcange` | *restituisce un JSONObject contenente i tassi di cambio delle valute richieste al giorno indicato*
[2](#2) | ` GET ` | `/convert` | *restituisce un JSONObject contente il risultato della conversione in euro al giorno indicato*
[3](#3) | ` GET ` | `/stats | *restituisce un JSONObject contenente le statistiche filtrate per il periodo di default (ultimi tre anni)*
[4](#4) | ` GET ` | `/stats/year` | *restituisce un JSONObject contenente le statistiche filtrate per l'anno scelto*
[5](#5) | ` GET ` | `/stats/month` | *restituisce un JSONObject contenente le statistiche filtrate per il mese scelto*
<a name="param"></a>
## Parametri 
N° | Parametri | Tipo | Valore di default
----- | ------------ | -------------------- | ----------------------
[1](#1) | `currency_list,year,month,day` | *String, int, String, String* | *"EUR,GBP,BTC",2021,"12","01"*
[2](#2) | `amount,currency,year,month,day` | *double,String,int,String,String* | *1.0,GBP,2021,"12","01"*
[3](#3) | `currency_list` | *String* |*"EUR,GBP,BTC"*
[4](#4) | `currency_list,year` | *int* |* "EUR,GBP,BTC",2021*
[5](#5) | `currency_list,month` | *int* | *"EUR,GBP,BTC","06"









