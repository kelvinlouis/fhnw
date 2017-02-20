clearvars;
syms x;

% Kürzester Abstand von Funktion zu zwei Punkten

f = ((x^2-2)^2*(x+1))/((x^2+1)^3);
p1 = [-2 0.3];
p2 = [3 0.5];

d1 = sqrt((x-p1(1))^2+(f-p1(2))^2);
d2 = sqrt((x-p2(1))^2+(f-p2(2))^2);

ex1 = double(solve(diff(d1)));
ex2 = double(solve(diff(d2)));

% Filter imaginary numbers
ex1 = ex1(imag(ex1) == 0);
ex2 = ex2(imag(ex2) == 0);

% Filter out imaginary numbers and only maximum
max1 = double(subs(diff(d1,2),x,ex1));
max1 = max1(max1 > 0 & imag(max1) == 0);

max2 = double(subs(diff(d2,2),x,ex2));
max2 = max2(max2 > 0 & imag(max2) == 0);

fprintf('d(P1)\n')
double(subs(d1,x,ex1(1)))
double(subs(d1,x,ex1(3)))

fprintf('d(P2)\n')
double(subs(d2,x,ex2(1)))
double(subs(d2,x,ex2(3)))

hold on;
fplot(f, 'Color', 'Red');
plot(p1(1), p1(2),'r.','MarkerSize',10, 'Color', 'Blue');
plot(p2(1), p2(2),'r.','MarkerSize',10, 'Color', 'Black');

% P1
% WICHTIG: Werte von der ersten Ableitung einsetzen (ex1)
plot(-1.9727, subs(f,x,-1.9727),'r.','MarkerSize',10, 'Color', 'Blue');
plot(0.7481, subs(f,x,0.7481),'r.','MarkerSize',10, 'Color', 'Blue');

% P2
% WICHTIG: Werte von der ersten Ableitung einsetzen (ex2)
plot(-0.4308, subs(f,x,-0.4308),'r.','MarkerSize',10, 'Color', 'Black');
plot(3.0095, subs(f,x,3.0095),'r.','MarkerSize',10, 'Color', 'Black');
