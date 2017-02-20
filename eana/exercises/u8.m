syms x
f= x^7 + 3*x^5 - 2*x^2 + x-1;
x0 = 1;
y0 = 0;
d = sqrt((x-x0)^2 + (f-y0)^2);
ezplot(d);
d1=diff(d);
extr=double(solve(d1));
double(subs(diff(d,2),x,extr));

% Minimaler Abstand zum Betrachter
double(subs(d,x,extr));