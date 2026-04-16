@echo off
echo Cleaning old .class files...

del *.class

echo Compiling Java files...

javac --module-path "D:\javafx-sdk-26\lib" --add-modules javafx.controls *.java

echo Running program...

java --module-path "D:\javafx-sdk-26\lib" --add-modules javafx.controls GadgetShop

pause