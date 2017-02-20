syms x;

% Eingeschlossene Fläche
f = cos(pi*x)^3;
g = (1/2) - (1/3)*x^2;
%ga2 = 1/2 - (2/3)*x^2;
%ga3 = 1/2 - (3/3)*x^2;
%ga4 = 1/2 - (4/3)*x^2;

% 1. Schnittpunkt bestimmen
d = inline(vectorize(f-g));
format long;
%xs = solve(f-g,x);
x1 = fzero(d, -1.5);
x2 = fzero(d, -0.3);
x3 = fzero(d, 0.3);
x4 = fzero(d, 1.5);


% 2. Flächenstücke zwischen Schnittpunkt bestimmen.
% 3. Betragsfunktion anwenden und alles aufsummieren

A1 = double(abs(int(f-g, x1, x2)));
A2 = double(abs(int(f-g, x2, x3)));
A3 = double(abs(int(f-g, x3, x4)));

A = A1 + A2 + A3;

hold;
p1 = ezplot(f)
p2 = ezplot(g)
%ezplot(ga2)
%ezplot(ga3)
%ezplot(ga4)

set(p1, 'color', 'red')
set(p2, 'color', 'blue')