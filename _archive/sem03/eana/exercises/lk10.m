syms x

%3
f = (x^2 - x)/(x^2 + 1);

%4
f4 = ((x-1)^2 * (x+2)*(x-3))/(x^2+1)^2;
f4_ = diff(f4);

ex4 = double(solve(f4_, x));
ex_y = double(subs(f4,x,ex4));

limit(f4,x,inf)

%ezplot(f4)
%axis([-10 10 -10 10])

% 5
f5 = x * (x^2-1) + sqrt(1+sqrt(1+x^2));
f5d = diff(f5);
ex5 = solve(f5d);
double(ex5)
ex5y = double(subs(f5,x,ex5));
double(ex5y)

%ezplot(f5)

% 6
f6 = 1 + 2 * sin(x) - (sin(x))^3;
f6d = diff(f6);
f6d2 = 2*cos(x) - cos(x)*3*sin(x)^2;
ex6 = solve(f6d);

subs(f6,x,ex6)
%ezplot(f6)

solve(cos(2*x) == 1/3)
