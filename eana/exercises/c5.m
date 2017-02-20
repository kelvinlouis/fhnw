% Exercise 1
syms x;

f1 = (1/x) + (1/x^3);
f1d = diff(f1);
f1d2 = diff(f1, 2);
f1t = 7*x^2-18*x+13;
% flt - f1 / f1
f1delta = @(x) (7*x^2 - 1/x - 18*x - 1/x^3 + 13)/(1/x + 1/x^3);
    
%hold
%ezplot(f1)
%ezplot(f1t)

fzero(@(x) abs(f1delta(x))-0.2, 0.6)
fzero(@(x) abs(f1delta(x))-0.2, 1)

% Exercise 2
f2 = (1-x)^(2/3);
f2d = diff(f2);
f2d2 = diff(f2,2);
f2d3 = diff(f2,3);
f2t = 1 - (2/3)*x - (1/9)*x^2 - (4/81)*x^3;
% f2 - f2t
f2err = @(x) (1-x)^(2/3) - (1 - (2/3)*x - (1/9)*x^2 - (4/81)*x^3);
double(subs(f2err,x,[0, 1/8, 1/4, 3/8, 1/2, 5/8, 3/4]))


% Ex 3
f3 = sin(4*pi/5)
f32 = sin(pi/5)
f3approx = 4*pi/5 - (((4*pi/5)^3)/6)
f3diff = f3 - f3approx
f32diff = f32 - f3approx
f3_100 = (mod(1000,2*pi)) - ((mod(1000,2*pi))^3)/6