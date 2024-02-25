# ProFencer
## Istruzioni per il deploy:

1. Scaricare eclipse

2.  Importare su eclipse il progetto Profencer (la cartella con la P maiuscola)

3.   Una volta importato il progetto corettamente  click destro sul progetto --> properties -->Libreries e in modulepath procedere all'aggiunta del file jcalendar-1.4.jar , 
     esso si troverà nella cartella lib contenuta nella cartella jcalendar-1.4 a sua volta contenuta in Profencer (cioè la cartella del progetto)
     inoltre se è presente l'import di jcalendar da un altro percorso rimuoverlo.
     chiudere la scheramta cliccando apply and close.

4.   A questo punto si può avviare l'applicazione facendo click su run
   
## Chiarimenti sulla struttura del progetto:

1. Il progetto da importare su eclipse è quello contenuto dalla cartella Profencer
   
2. Sotto la cartella Profencer accedendo alla cartella src si potranno esplorare i file scritti, in particolaare  dentro la cartella Main ci sarà una divisione tra "ui" e "domain" per distinguere il codice relativo alla sola parte Grafica contenuto in ui, userInterface, e il codice in cui sono scritte le classi in java contenute in domain. (./Profencer/src/Main)

3. Per visionare i test invece bisognerà uscire dalla cartella relativa al progetto eclipse e accedere alla cartella src che presenterà una divisone tra test e main, in test si troverà il file in cui sono stati svolti. (./src)
