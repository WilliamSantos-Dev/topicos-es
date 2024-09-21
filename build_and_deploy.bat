@echo off

REM Diretórios dos serviços
set SERVICES=catalogo estoque preco discovery gateway

REM Loop para rodar mvnw clean install em cada serviço
for %%S in (%SERVICES%) do (
    echo Executando mvnw clean install no diretorio %%S
    cd %%S
    call mvnw.cmd clean install
    if errorlevel 1 (
        echo Falha na instalação do %%S, saindo...
        exit /b 1
    )
    cd ..
)

REM Derrubar os containers Docker existentes
echo Executando docker-compose down
docker-compose down

REM Subir os containers com rebuild
echo Executando docker-compose up --build
docker-compose up --build
