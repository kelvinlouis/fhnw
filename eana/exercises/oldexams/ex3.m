% FUTURE KELVIN: DO NOT USE THIS AS A REFERENCE

clearvars;
syms x;

% Kürzester Abstand von Funktion zu einem Punkt

f = (x-1)^2*(x-2)*x*(x+1);
p1 = [1/2 1/2];
p2 = [1 -1/2];
p3 = [3/2 0];
p4 = [-1/2 1];

d = @(x, p) sqrt((x-p(1))^2 + (subs(f,x,x)-p(2))^2);

exp = @(x,p) double(solve((diff(d(x,p)) == 0), x));
exp2 = @(x,p) double(solve((diff(d(x,p),2) > 0), x));
%d2p1 = double(solve((diff(d(x,p1),2) > 0), x));
%d2p1 = @(x) ((x - 1)^2*(x + 1)*(x - 2) + x*(x - 1)^2*(x + 1) + x*(x - 1)^2*(x - 2) + x*(2*x - 2)*(x + 1)*(x - 2))^2/((x*(x - 1)^2*(x + 1)*(x - 2) - 1/2)^2 + 2319238795538341/1125899906842624)^(1/2) + ((x*(x - 1)^2*(x + 1)*(x - 2) - 1/2)*(2*x*(x - 1)^2 + 2*(x - 1)^2*(x + 1) + 2*(x - 1)^2*(x - 2) + 2*(2*x - 2)*(x + 1)*(x - 2) + 2*x*(x + 1)*(x - 2) + 2*x*(2*x - 2)*(x + 1) + 2*x*(2*x - 2)*(x - 2)))/((x*(x - 1)^2*(x + 1)*(x - 2) - 1/2)^2 + 2319238795538341/1125899906842624)^(1/2) - ((x*(x - 1)^2*(x + 1)*(x - 2) - 1/2)^2*((x - 1)^2*(x + 1)*(x - 2) + x*(x - 1)^2*(x + 1) + x*(x - 1)^2*(x - 2) + x*(2*x - 2)*(x + 1)*(x - 2))^2)/((x*(x - 1)^2*(x + 1)*(x - 2) - 1/2)^2 + 2319238795538341/1125899906842624)^(3/2);

hold on;
fplot(f, 'Color', 'Red');
plot(p1(1), p1(2),'r.','MarkerSize',10, 'Color', 'Blue');
plot(p2(1), p2(2),'r.','MarkerSize',10, 'Color', 'Black');  
plot(p3(1), p3(2),'r.','MarkerSize',10, 'Color', 'Green');  
plot(p4(1), p4(2),'r.','MarkerSize',10, 'Color', 'Cyan');  