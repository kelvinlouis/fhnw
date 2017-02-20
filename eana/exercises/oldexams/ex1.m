clearvars;
syms x;

% Tangentenfunktion finden die durch einen Punkt geht
% Andere Tangentenfunktionen finden mit der gleichen Steigung.

f = (x/(1+x^2));                                                % Ursprung Funktion
fd = diff(f);                                                   
ft = fd * (-2-x) + f;                                           % Tangentenfunktion mit x = -2
ns = double(solve(ft));                                         % x0 von Tangentenfunktion finden
ft0 = subs(fd,x,ns(1))*(x-ns(1))+subs(f,x,ns(1));               % Gefundene x0 in Tangentenfunktion einsetzen

hold on;
ezplot(f);
ezplot(ft0);
plot(-2,0,'r.','MarkerSize',10);                                % Punkt (-2,0) plotten

double(subs(f,x,ns(1)))                                         % Y-Koordinate von f(x0)
m1 = 0.1745;
x0s = double(solve(fd-m1));                                     % Andere x0 von Tangentenfunktionen mit gleicher Steigung finden: Steigung = f'(x)
x0s(3)
ft1 = subs(fd,x,x0s(3))*(x-x0s(3))+subs(f,x,x0s(3));            % Die andere x0 in Tangentenfunktion einsetzen
ezplot(ft1);
