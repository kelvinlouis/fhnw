clearvars;
syms x;

f = sin(5*sqrt(1+x^2));
g = 1 - (x^2/3);
d = f-g;

hold on;
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
fplot(f, 'Color', 'Red');
fplot(g, 'Color', 'Blue');
fplot(d, 'Color', 'Green');

% Schnittpunkte berechnen
di = @(x) sin(5*(x^2 + 1)^(1/2)) + x^2/3 - 1;

A1 = double(int(g,-2.1722,-1.5504) - int(f,-2.1722,-1.5504))
A2 = double(int(f,-1.5504,-0.9868) - int(g,-1.5504,-0.9868))
A3 = double(int(g,-0.9868,0.9868) - int(f,-0.9868,0.9868))
A4 = double(int(f,0.9868,1.5504) - int(g,0.9868,1.5504))
A5 = double(int(g,1.5504,2.1722) - int(f,1.5504,2.1722))

A = abs(A1) + abs(A2) + abs(A3) + abs(A4) + abs(A5)
