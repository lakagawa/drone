#!/bin/bash
: '
Automações:
 - Geração das configurações dos drones;
 - Inicialização de múltiplos processos/drones (PIDs);
 - Geração de logs.
'

. utils.sh

function startDrone() {
	droneAppConfig=$1;
	"$JAVA_HOME"/java -jar $DRONE_APP --spring.config.location=$droneAppConfig &
	pid=$!;
	echo "$pid" >> $PID_FILE
	log "STARTED PID $pid - $droneAppConfig";
}

function createConfigFile(){
	droneId=$1;
	rastreamento=$2;
	
	echo "producer.url=$PRODUCER_URL" > $CONFIG_DIR/application_$droneId.$CONFIG_EXT;
	echo "drone.id=$droneId" >>  $CONFIG_DIR/application_$droneId.$CONFIG_EXT;
	echo "drone.rastreamento=$rastreamento" >> $CONFIG_DIR/application_$droneId.$CONFIG_EXT;
	echo "drone.intervalo_envio=$INTERVALO" >> $CONFIG_DIR/application_$droneId.$CONFIG_EXT;
	
	log "Created the drone configuration file: application_$droneId.$CONFIG_EXT";
	startDrone "$CONFIG_DIR/application_$droneId.$CONFIG_EXT";
}

echo "Enter the amount of drones that are tracking: ";
read drone_active_count;

echo "Enter the amount of drones not tracking: ";
read drone_inactive_count;

init;
if [ $? -eq 0 ]; then	
	for ((counter=1; counter<=$drone_active_count; counter++ )) do
		createConfigFile "drone_active_$counter" true;
	done;

	for ((counter=1; counter<=$drone_inactive_count; counter++ )) do
		createConfigFile "drone_inactive_$counter" false;
	done;
fi
