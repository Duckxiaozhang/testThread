public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    // 构造函数
    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("三边不能构成三角形");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 判断三边是否能构成三角形
    private boolean isValidTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    // 计算三角形面积
    public double getArea() {
        double s = (a + b + c) / 2; // 半周长
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // 海伦公式
    }

    // 主函数，用于测试
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(3, 4, 5);
            System.out.println("三角形的面积是：" + triangle.getArea());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}