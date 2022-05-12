set CLASSPATH=%CLASSPATH%;..\..\JKeyboard.jar
md classes
javac -d classes src/*.java
cd classes
java -cp ./;..\..\..\JKeyboard.jar App
cd..
pause..