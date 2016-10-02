syms t
% A.6 

% 3a
f1 = @(x)(sin(2*pi*x));

% 3b
f2_ = @(x)(2*cos(2*pi*x));
f2 = @(x)(2*cos(2*pi*x+(pi/4)));

% 3c
f3_ = @(x)(sin(x)^2);
f3 = @(x)((1/2)+(1/2)*cos(2*t-pi));

% 3d
f4 = @(x)(sin(x)*cos(x));

% 3e
f5__ = @(x)(sin(2*x));
f5_ = @(x)(cos(x));
f5 = @(x)(sin(2*x)*cos(x));

% 3f
f6__ = @(x)(sin(x));
f6_ = @(x)(cos(2*x));
f6 = @(x)(f6__(x)*f6_(x));

% Plot with coordinates
hold
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
xticks([-3*pi -2*pi -pi 0 pi 2*pi 3*pi])
xticklabels({'-3\pi','-2\pi','-\pi','0','\pi','2\pi','3\pi'})

%ezplot(f1(t))
%ezplot(f2_(t))
%ezplot(f2(t))
%ezplot(f3_(t));
%ezplot(f3(t));
%ezplot(f4(t));
%ezplot(f5__(t));
%ezplot(f5_(t));
%ezplot(f5(t));

%ezplot(f6__(t));
%ezplot(f6_(t));
%ezplot(f6(t));