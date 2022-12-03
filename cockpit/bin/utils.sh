#!/bin/bash
: '
Funcionalidades:
 - Gravação de logs;
 - Eliminação de todos os arquivos utilizados;
 - Inicialização da estrutura do cockpit.
'

. ../config/config.env

function log() {
	msg=$1;
	if [ ! -d "$LOG_DIR" ]; then
		mkdir $LOG_DIR;
	fi	
	echo "$msg" >> $LOG_DIR/drones_$LOG_TIME_FMT.log;
}

function clean() {
	clear;
	if [ -d "$CONFIG_DIR" ]; then
		rm -rf $CONFIG_DIR;
	fi
	
	if [ -d "$TEMP_DIR" ]; then
		rm -rf $TEMP_DIR;
	fi	
}

function init() {
	clean;
	if [ -f $DRONE_APP ]; then
		echo "Loaded $DRONE_APP";
		mkdir $CONFIG_DIR;
		mkdir $TEMP_DIR;
	else
		echo "Drone App $DRONE_BIN not found IN $APP_DIR. Please check.";
		return 1;
	fi
}
