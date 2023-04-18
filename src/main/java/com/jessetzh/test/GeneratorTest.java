package com.jessetzh.test;


import com.jessetzh.parameters.Img2ImgParameter;
import com.jessetzh.parameters.SamplerEnums;
import com.jessetzh.parameters.Text2ImgParameter;
import com.jessetzh.request.Img2Img;
import com.jessetzh.request.Text2Img;
import com.jessetzh.res.SdResponses;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 */

public class GeneratorTest {

	//支持直接使用 gradio.live WebUI 地址调用
	static final String URL = "https://xxxxxxxxxxxxx.gradio.live/";

	public static void main(String[] args) throws IOException {
		new GeneratorTest().img2imgTest();
	}

	private void text2ImgText() throws IOException {
		Text2ImgParameter parameter = new Text2ImgParameter(URL);
		//如需要代理则解开下列代码注释
//		parameter.getBasicParameter().setProxyEnable(true);
//		parameter.getBasicParameter().setProxyHost("127.0.0.1");
//		parameter.getBasicParameter().setProxyPort(7890);
		parameter.setPrompt("One Golden Retriever");
		SdResponses res = Text2Img.generate(parameter);
		for (String image : res.getImages()) {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(image)));
			File output = new File("image.png");
			ImageIO.write(bufferedImage, "png", output);
		}
	}

	private void img2imgTest() throws IOException {
		Img2ImgParameter parameter = new Img2ImgParameter(URL);
		//重绘幅度
		parameter.setDenoisingStrength(new BigDecimal("0.55"));
		parameter.setSeed(-1);
		parameter.setSteps(30);
		parameter.setCfgScale(7);
		parameter.setWidth(512);
		parameter.setHeight(512);
		parameter.setSamplerName(SamplerEnums.DPM_2M_Karras.getInfo());
		Path path = Paths.get("test.jpeg");
		byte[] bytes = Files.readAllBytes(path);
		Base64.Encoder encoder = Base64.getEncoder();
		String base64String = encoder.encodeToString(bytes);
		parameter.setInit_images(new String[]{base64String});
		parameter.setPrompt("dog");
		parameter.setNegativePrompt("cat");
		SdResponses res = Img2Img.generate(parameter);
		for (String image : res.getImages()) {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(image)));
			File output = new File("image.png");
			ImageIO.write(bufferedImage, "png", output);
			System.out.println(res.getInfo());
		}
	}

}
