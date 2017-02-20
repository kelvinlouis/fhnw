clearvars;
syms x;

f = 2-((x-1)^2)/2;
g = 4-(x-5)^2;
p = [-6 0];

% Nach x0 suchen in Tangentenfunktion
Tx0 = diff(f)*(p(1)-x) + f;
x0 = double(solve(Tx0,x))

% Gefundene x0 in Tangentenfunktion verwenden
Tf1 = subs(diff(f),x,x0(2))*(x-x0(2))+subs(f,x,x0(2));

hold on;
fplot(f, 'Color', 'Red');
fplot(g, 'Color', 'Blue');
plot(p(1), p(2),'r.','MarkerSize',10, 'Color', 'Green');
fplot(Tf1, 'Color', 'Green');

% Teilaufgabe b :( nicht geschafft
Tgx0 = diff(g)*(0-x) + g;
gx0 = double(solve(Tgx0,x));
Tg1 = subs(diff(g),x,gx0(1))*(x-gx0(1))+subs(g,x,gx0(1));
fplot(Tg1, 'Color', 'Black')
