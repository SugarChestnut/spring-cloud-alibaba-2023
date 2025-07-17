package cn.rtt.scg.flux.example;

import org.springframework.beans.BeanUtils;

/**
 * @author rtt
 * @date 2025/7/4 09:18
 */
public class BeanTest {

    public static void main(String[] args) {
        BeProperties b1 = new BeProperties();
        b1.setA("xx");
        b1.setB("yy");
        b1.setP(new P());

        BeProperties b2 = new BeProperties();
        BeanUtils.copyProperties(b1, b2);

        System.out.println(b1.getP());
        System.out.println(b2.getP());
    }

    static class BeProperties {

        private String a;

        private String b;

        private P p;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public P getP() {
            return p;
        }

        public void setP(P p) {
            this.p = p;
        }

        @Override
        public String toString() {
            return "不展示";
        }
    }

    static class P {

    }
}
