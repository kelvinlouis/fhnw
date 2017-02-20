syms x;

diff(3*x^(7/3)+2*x+(x/(sqrt(1+x^2)))+1)
diff(sqrt(1+(1-x)^2))
diff((x^3+x)/(x^3+1))
diff(exp(2*sin(2*x)))
diff(log(1+x^2)^4)

f = ((x+2)^2);
f1 = diff(f);
double(solve((1 == (-1/(f1))*(1-x) + f),x))

% 6
fa = (x+1+sqrt(2))^2 + (x-1+sqrt(2))^2 + 1;
fa2 = (2*x^2+4*x*sqrt(2)+7);

double(solve(fa,x))
double(solve(fa2,x))
