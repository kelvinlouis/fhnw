package ch.fhnw.oop1.lec15;

/**
 * Created by Kelvin on 01-Feb-16.
 */
public class SoundProcessor {
    class StereoSample {
        private int left;
        private int right;

        public StereoSample(int l, int r) {
            left = l;
            right = r;
        }
    }

    private StereoSample[] samples;

    public SoundProcessor() {
        StereoSample[] samples = new StereoSample[1000];
    }
}
