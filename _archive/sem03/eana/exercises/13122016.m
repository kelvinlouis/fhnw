syms x a

% Exam Review (5)
f = exp(sqrt(1+x^2));
g = 3+a*x^2;
dfg = (f-g)^2;
%d = subs(dfg, x, -3) + subs(dfg, x, -2) + subs(dfg, x, -1) + subs(dfg, x, 0) + subs(dfg, x, 1) + subs(dfg, x, 2) + subs(dfg, x, 3);
d = symsum(dfg,x,-3,3);
%ezplot(d)
extr = double(solve(diff(d)))
double(subs(diff(d,2),a,extr))

% Lesson
fb = sqrt(1+x);
P1 = subs(fb,x,0)+subs(diff(fb),x,0)*x
P2 = P1 + (1/2) * subs(diff(fb,2),x,0)*x^2
P3 = P2 + (1/6)* subs(diff(fb,3),x,0)*x^3
P4 = P3 + (1/24)* subs(diff(fb,4),x,0)*x^4

ezplot(fb)
hold
p = ezplot(P1)
p2 = ezplot(P2)
p3 = ezplot(P3)
p4 = ezplot(P4)

p3_mat = taylor(fb, 'order', 3+1, 'expansionPoint', 0)
p5_mat = taylor(fb, 'order', 5+1, 'expansionPoint', 0);
ezplot(p5_mat)

fx = (x^2+2*x-3)/(x^2+1)
% 1, 2 and 3rd Taylor x_0 = 0


%set(p, 'color', 'purple')