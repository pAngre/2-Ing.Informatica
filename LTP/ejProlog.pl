% Ex2022
% pepe es jefe de juan y sus ingresos son 300 euros + que los de juan

jefe(pepe,juan,300).
jefe(juan,ana,200).
jefe(ana,mario,200).
jefe(mario,luisa,400).
jefe(pepe,lola,400).
jefe(lola,jorge,600).
jefe(ana,toni,500).
jefe(carla,marco,400).
jefe(carla,elisa,400).
jefe(lola,carla,200).

mileurista(luisa).
mileurista(toni).
mileurista(jorge).
mileurista(marco).
mileurista(elisa).


ingresos(X,1000) :- mileurista(X).
ingresos(X,I) :- jefe(X,Y,Z), ingresos(Y,IY), I is Z + IY

cadenaMando(X,Y,[Y]) :- jefe(X,Y,_).
cadenaMando(X,Y,Z|R) :- jefe(X,Y,_), cadenaMando(Z,Y,R). 

% Ex2021
% "Fundamentos de Algoritmia", de "G. Brassard" y "P. Bratley", libro publicado por "Prentice Hall" en 1997
book("Fundamentos de Algoritmia", ["G. Brassard", "P. Bratley"], "Prentice Hall", 1997).
book("Sistemas Operativos", ["William Stallings"], "Prentice Hall", 1997).
book("Fundamentos de Bases de Datos", ["H. Korth", "A. Silberschatz"], "McGrawHill", 1993).
book("Fisica Cuantica", ["Robert Eisberg", "Robert Resnick"], "Limusa", 1979).
book("Sistemas Operativos", ["Milan Milenkovic"], "McGrawHill", 1994).

published(B,E,Y) :- book(B,_,E,A), A < Y


% Ex 2020

modelsSelector(M,B,S,A) :- model(M,B),since(M,A),segment(M,S).

comparatore(M1,M2) :- segment(M1,X),segment(M2,X), model(M1,Y1),model(M2,Y2), Y1 \== Y2

