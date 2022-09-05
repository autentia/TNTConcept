#!/usr/bin/env bash

function copy(){
	filePath=$1
	newPath=$2

	if [ -f $filePath ];then
		if ! [ -d $newPath ];then
			newPathDir=$(echo $newPath | awk '{ sub("/[^/]*$",""); print}')
			mkdir -p $newPathDir
		fi
		cp $filePath $newPath
	else
		echo "[!] Hubo un error al copiar $filePath a la ruta $newPath."
	fi
}
echo "[+] Copying to Maven repository tntconcept-core dependencies..."
copy tntconcept-core/jars_to_install/jta-1.0.1B.jar ~/.m2/repository/javax/transaction/jta/1.0.1B/jta-1.0.1B.jar

echo "[+] Copying to Maven repository tntconcept-web dependencies..."
copy tntconcept-web/jars_to_install/olap4j-0.9.6.jar ~/.m2/repository/org/olap4j/olap4j/0.9.6/olap4j-0.9.6.jar
copy tntconcept-web/jars_to_install/mondrian-3.0.0.jar ~/.m2/repository/mondrian/mondrian/3.0.0/mondrian-3.0.0.jar
copy tntconcept-web/jars_to_install/jpivot-1.8.0.jar ~/.m2/repository/com/tonbeller/jpivot/jpivot/1.8.0/jpivot-1.8.0.jar
copy tntconcept-web/jars_to_install/javacup-0.10k.jar ~/.m2/repository/java_cup/javacup/0.10k/javacup-0.10k.jar
copy tntconcept-web/jars_to_install/wcf-1.7.0.jar ~/.m2/repository/com/tonbeller/wcf/wcf/1.7.0/wcf-1.7.0.jar
copy tntconcept-web/jars_to_install/tbutils-wcf-1.7.0.jar ~/.m2/repository/com/tonbeller/tbutils/tbutils-wcf/1.7.0/tbutils-wcf-1.7.0.jar
copy tntconcept-web/jars_to_install/eigenbase-xom-1.0.jar ~/.m2/repository/org/eigenbase/xom/eigenbase-xom/1.0/eigenbase-xom-1.0.jar
copy tntconcept-web/jars_to_install/eigenbase-properties-1.0.jar ~/.m2/repository/org/eigenbase/util/property/eigenbase-properties/1.0/eigenbase-properties-1.0.jar
copy tntconcept-web/jars_to_install/eigenbase-resgen-1.0.jar ~/.m2/repository/org/eigenbase/resgen/eigenbase-resgen/1.0/eigenbase-resgen-1.0.jar

echo "All dependencies copied!"
