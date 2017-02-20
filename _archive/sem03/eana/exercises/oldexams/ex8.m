clearvars;
syms x xi;

% Riemannsum: Approximation der Flächen
f = 2/(1+x^2);
P = int(f,-1,1)

% N = 10
double(symsum(subs(f,x,(-1+xi*(2/10)))* (2/10),xi,0,10-1))

% N = 100
double(symsum(subs(f,x,(-1+xi*(2/100)))* (2/100),xi,0,100-1))

% N = 1000
double(symsum(subs(f,x,(-1+xi*(2/1000)))* (2/1000),xi,0,1000-1))

hold on;
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
fplot(f)