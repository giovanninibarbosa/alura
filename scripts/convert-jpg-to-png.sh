#!/bin/bash

for [variável] in $@
do
    convert $CAMINHO_IMAGENS/$[variável].jpg $CAMINHO_IMAGENS/$[variável].png
done 