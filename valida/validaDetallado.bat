@echo off
rem Fichero por lotes del comprobador de la Pr5.
rem (c) Marco Antonio Gomez Martin, 2010
rem El %1\.. es para intentar que funcione desde el explorador
rem pero puede que s�lo lo haga si el directorio del usuario
rem est� en la misma unidad que el valida.bat
for %%F in ("%0") do set dirname=%%~dpF

if "-v"=="-g" goto grafico
if "%1"=="" goto error
cd %1\..
:grafico
echo Validando la entrega de la Pr5...
java -cp "%dirname%/prog/check.jar" es.fdi.gaia.validaPracticas.Valida -v Pr5 %1
pause
goto end
:error
echo Error: No has indicado el nombre del fichero a validar.
:end
