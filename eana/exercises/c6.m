syms x;

%1
f1 = (x^2 - 2);
f1d = (2*x);

f1n = x - (f1/f1d);

%2
f2 = 1 - (2/x^2);
f2d = (4*x / x^4);
f2n = x - (f2/f2d);

ezplot(f1)