#!/bin/bash
#
# Fichero por lotes del validador de la Pr5.
# (c) Marco Antonio Gomez Martin, 2010
#

if [ -z "$1" ]; then
    echo "Error: no has indicado el nombre del fichero a validar."
    exit 1
fi

java -cp prog/check.jar es.fdi.gaia.validaPracticas.Valida Pr5 "$1"
