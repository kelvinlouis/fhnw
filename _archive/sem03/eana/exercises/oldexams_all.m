clearvars;
syms x;
syms x0;

% 1
f1 = (x/(1+x^2));
f1d = diff(f1);
ft1 = f1d * (-2-x) + f1;
ns1 = double(solve(ft1));
ft0 = subs(f1d,x,ns1(1))*(x-ns1(1))+subs(f1,x,ns1(1));

hold on;
ezplot(f1);
ezplot(ft0);
plot(-2,0,'r.','MarkerSize',10);
double(subs(f1,x,ns1(1)))
m1 = 0.1745;