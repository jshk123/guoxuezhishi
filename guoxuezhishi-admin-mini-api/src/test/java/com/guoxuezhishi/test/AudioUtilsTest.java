package com.guoxuezhishi.test;

import com.guoxuezhishi.utils.AudioUtils;
import org.junit.Test;

/**
 * @author: jiang
 * @date: 2019/7/29
 */
public class AudioUtilsTest {
    //测试播放音频
    @Test
    public void testPaly() throws Exception {
        AudioUtils utils = AudioUtils.getInstance();
        utils.playMP3("D:\\demo\\guoxuezhishi\\output.mp3");
    }

    @Test
    public void testConvert() throws Exception {
        AudioUtils utils = AudioUtils.getInstance();
        utils.convertMP32Pcm("D:\\demo\\guoxuezhishi\\output.mp3", "D:\\demo\\guoxuezhishi\\output.pcm");
    }
}
