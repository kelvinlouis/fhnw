clearvars;
syms x;

f = x^5 - (1/2)*x^4-5*x^3+4*x-1;
g = -x^2;

hold on;
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
fplot(f, 'Color', 'Red');
fplot(g, 'Color', 'Blue');

% Schnittpunkte berechnen
xs = double(solve(f-g))

% Bestimmte Integrale aufstellen:
% Obere Funktion - Untere Funktion, diese wechseln in der Regel, wenn sie
% sich schneiden!
A1 = double(int(f,xs(1),xs(2)) - int(g,xs(1),xs(2)))
A2 = double(int(g,xs(2),xs(3)) - int(f,xs(2),xs(3)))
A3 = double(int(f,xs(3),xs(4)) - int(g,xs(3),xs(4)))
A4 = double(int(g,xs(4),xs(5)) - int(f,xs(4),xs(5)))
A = abs(A1) + abs(A2) + abs(A3) + abs(A4)