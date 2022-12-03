#!/bin/bash
: '
Automações:
 - Parada de todos os processos/drones inicializados (PIDs);
 - Eliminação de todos os arquivos gerados.
'

. utils.sh

if [ -f "$PID_FILE" ]; then
	while read id; do
		log "Killing PID $id...";
		result=`kill -9 $id 2>&1`;
		log "$result";
	done < $PID_FILE;
	clean;
else
	echo "No PID found.";
fi
