# Progetto-OOP-Gennaio-2022
# CurrencyLayer App
L'applicazione nasce con l'obiettivo di fornire uno strumento tecnico che possa essere di aiuto a qualsiasi economista e investitore interessato nel **Forex**, il mercato delle valute, che rappresenta il mercato più grande al mondo in termini di valori delle transazioni e di liquidità (per sua stessa natura).
# Contenuti :

* [Descrizione](#intro)
* [Avvertenze](#warn)
* [Rotte](#rotte)
* [Parametri](#param)
* [Formato restituto](#form)
* [Test](#test)
* [Autori](#autor)

<a name="intro"></a>
## Descrizione 

L'applicazione utilizza i dati ricevuti dall'API Currency Layer, che fornisce informazioni aggiornate quotidianamente sul valore di più di 160 valute in tutto il mondo, inclusi due metalli preziosi, rispetto al dollaro statunitense. 
**Una lista di tutte le valute supportate con il relativo codice identificativo (tre lettere in maiuscolo) da inserire nell'app è disponibile al seguente link: https://currencylayer.com/currencies .**

A partire dai dati ricevuti l'applicazione offre diverse funzionalità per poter effettuare un'analisi storica delle valute.
## Funzioni 
* **Tasso di cambio storico**
  in un giorno a scelta dell'utente (dal 1990 ad oggi), su un set di valute scelto dall'utente, rispetto all'USD.
* **Convertitore in euro**
 di un qualsiasi ammontare di una certa valuta in un giorno scelto dall'utente con riferimento al tasso storico di quel giorno.
* **Statistiche annuali**
 media,varianza e scostamento medio del valore in dollari di un set di valute all'interno di un anno solare.
* **Statistiche mensili**
 media,varianza e scostamento medio del valore in dollari di un set di valute nello stesso mese di diversi anni, per valutare il miglior periodo di investimento.
<a name="warn"></a>
## Avvertenze :warning:
Il programma è stato realizzato per un progetto d'esame universitario e sfrutta il pacchetto gratuito dell'API Currency Layer. Questo pacchetto permette all'utente di richiedere informazioni solamente su un singolo giorno, e non su un lasso di tempo entro due date (funzione a pagamento).
Per questo motivo per provare il funzionamento delle statistiche su periodi estesi l'applicazione sfrutta un file incluso nella directory del programma **"quotes.list.txt**, dove sono stati salvati dati relativi al valore di 3 valute: *EUR,GBP,BTC* (uniche ammesse per le rotte /stats)  
nei 12 mesi degli ultimi 3 anni: *2019,2020,2021* (unici ammessi per la rotta /stats/year).
L'utente che fosse interessato ad ottenere un servizio completo può liberamente acquistare la versione a pagamento dell'API ed effettuare una lieve modifica al codice, che invece di andare a leggere da file locale i dati per il calcolo delle statistiche andrebbe a chiederli direttamente all'API come fa già per le funzioni gratuite.
Infine si ricorda che per utilizzare il programma si deve modificare la variabile "key" nella classe HistoricalRate contenuta nel package CurrencyLayer\src\main\java\com\progettoOOP\CurrencyLayer\service sostituendola con la propria key ottenibile gratuitamente iscrivendosi su https://currencylayer.com/product.

<a name="rotte"></a>
## Rotte 
Le richieste vanno effettuate all'indirizzo http://localhost:8080

N° | Tipo | Rotta | Descrizione
----- | ------------ | -------------------- | ----------------------
[1](#1) | ` GET ` | `/exhcange` | *restituisce un JSONObject contenente i tassi di cambio delle valute richieste, al giorno indicato*
[2](#2) | ` GET ` | `/convert` | *restituisce un JSONObject contente il risultato della conversione in euro al giorno indicato*
[3](#3) | ` GET ` | `/stats` | *restituisce un JSONObject contenente le statistiche filtrate per il periodo di default (ultimi tre anni)*
[4](#4) | ` GET ` | `/stats/year` | *restituisce un JSONObject contenente le statistiche filtrate per l'anno scelto*
[5](#5) | ` GET ` | `/stats/month` | *restituisce un JSONObject contenente le statistiche filtrate per il mese scelto*
<a name="param"></a>
## Parametri 
:warning: Le valute da inserire nel parametro *currency_list* vanno scritte con il relativo codice (vedi [Descrizione](#intro)) e separate da virgole.


N° | Parametri | Tipo | Valore di default |
----- | ------------ | -------------------- | ----------------------
[1](#1) | `currency_list,year,month,day` | *String, int, String, String* | * "EUR,GBP,BTC",2021, 01 ,01 * |
[2](#2) | `amount,currency,year,month,day` | *double,String,int,String,String* | * 1,"GBP",2021,01,01 * |
[3](#3) | `currency_list` | *String* |* "EUR,GBP,BTC" * | 
[4](#4) | `currency_list,year` | *String,int* |* "EUR,GBP,BTC",2021* |
[5](#5) | `currency_list,month` | *String,int* | * "EUR,GBP,BTC", 06 |

<a name="form"></a>
## Formato restituito (valori di Default)
<a name=1></a>
### 1. Exchange
```json
{
    "Quotes": {
        "USDEUR": 0.821304,
        "USDGBP": 0.731368,
        "USDBTC": 3.4075045E-5
    },
    "Date": "01-01-2021"
}
```

<a name=2></a>
### 2. Convert
```json
{
    "result": "1.2168976493365857 EUR",
    "input": "1.0 GBP"
}
```
### 3. Stats
```json
[
    {
        "Scostamento medio": 5.589174712345682E-5,
        "Currency": "BTC",
        "Media": 9.793935422222226E-5,
        "Varianza": 5.476449991604284E-9
    },
    {
        "Scostamento medio": 0.026477135802469128,
        "Currency": "EUR",
        "Media": 0.8711520277777779,
        "Varianza": 8.704672216381178E-4
    },
    {
        "Scostamento medio": 0.026637722222222236,
        "Currency": "GBP",
        "Media": 0.7629249999999999,
        "Varianza": 0.0010126013654444448
    }
]
```
### 4.Stats by Year
```json
[
    {
        "Scostamento medio": 5.190534833333332E-6,
        "Currency": "BTC",
        "Media": 2.2956204E-5,
        "Varianza": 3.329386925975467E-11
    },
    {
        "Scostamento medio": 0.014385083333333326,
        "Currency": "EUR",
        "Media": 0.8432437499999997,
        "Varianza": 3.324545058541665E-4
    },
    {
        "Scostamento medio": 0.008117041666666694,
        "Currency": "GBP",
        "Media": 0.7274747500000002,
        "Varianza": 1.2109563668749997E-4
    }
]
```
### 5.Stats by Month
```json
[
    {
        "Scostamento medio": 7.709443444444444E-5,
        "Currency": "BTC",
        "Media": 1.4435834833333332E-4,
        "Varianza": 8.521370163722672E-9
    },
    {
        "Scostamento medio": 0.02695511111111108,
        "Currency": "EUR",
        "Media": 0.8617366666666667,
        "Varianza": 8.769100695555544E-4
    },
    {
        "Scostamento medio": 0.018228888888888888,
        "Currency": "GBP",
        "Media": 0.7567566666666666,
        "Varianza": 4.653543315555556E-4
    }
]
```

<a name="test"></a>
## Test
Per verificare il funzionamento del programma sono state implementate 3 classi di test tramite utilizzo del framework JUNIT.
* **HistoricalRateTest** verifica la correttezza della chiamata API e del salvataggio della risposta in un JSONObject-
* **FileReadTest** verifica la correttezza della lettura da file e del salvataggio del contenuto in un JSONArray.
* **FilterTest** verifica la correttezza del metodo di filtraggio che dal JSONArray salva i valori dei tassi di cambio su un Vector di variabili Double.


<a name="author"></a>
## Author
Il progetto è stato sviluppato con equa suddivisione del lavoro da
* [Amerigo Aloisi](https://github.com/Amerigo25)
* [Marco Di Vita](https://github.com/likaj6638)


