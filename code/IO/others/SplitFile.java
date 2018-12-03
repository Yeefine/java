/* @16130110047 王一凡 528378795@qq.com */
package com.IO.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.IO.util.FileUtil;


public class SplitFile {
	//文件的路径
	private String filePath;
	//文件名
	private String fileName;
	//文件大小
	private long length;
	//块数
	private int size;
	//每块的大小
	private long blockSize;
	//分割后的存放目录
	private String destBlockPath;
	//每块的名称
	List<String> blockPath;
	
	public SplitFile() {
		blockPath = new ArrayList<String>();
	}
	
	public SplitFile(String filePath, String destBlockPath) {
		this(filePath, 1024, destBlockPath);
	}
	
	public SplitFile(String filePath, long blockSize, String destBlockPath) {
		this();
		this.blockSize = blockSize;
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		init();
	}
	
	/**
	 * 初始化操作 计算 块数、 确定文件名
	 * @param args
	 */
	public void init() {
		File src = null;
		//健壮性
		if(null == filePath || !((src = new File(filePath)).exists())) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//文件名
		this.fileName = src.getName();
		
		//计算块数 实际大小 与每块大小
		this.length = src.length();
		//修正 每块大小
		if(this.blockSize > length) {
			this.blockSize = length;
		}
		
		//确定块数
		size = (int)(Math.ceil(length * 1.0 / this.blockSize));
		//确定文件路径
		initPathName();
	}
	
	private void initPathName() {
		for(int i = 0; i < size; i++) {
			this.blockPath.add(destBlockPath + "/" + this.fileName + ".part" + i);
		}
	}
	
	/**
	 * 文件分割
	 * 0）、第几块
	 * 1）、起始位置
	 * 2）、实际大小
	 * @param destPath 分割文件存放目录
	 * @throws IOException 
	 */
	public void split() throws IOException {

		long beginPos = 0; //起始位置
		long actualBlockSize = this.blockSize;  //实际大小
		
		//计算所有块的大小、 位置、索引
		for(int i = 0; i < size; i++) {
			if(i == size - 1) {  //最后一块
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos += actualBlockSize;  //本次的终点， 下一次的起点
		}
		
	}
	/**
	 * 文件的分割  输入 输出
	 * 文件拷贝
	 * @param idx
	 * @param beginPos
	 * @param actualBlockSize
	 * @throws IOException 
	 */
	private void splitDetail(int idx, long beginPos, long actualBlockSize) throws IOException {
		//创建源
		File src = new File(this.filePath);  //源文件
		File dest = new File(this.blockPath.get(idx));  //目标文件
		
		//选择流
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src, "r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			//读取文件
			raf.seek(beginPos);
			//缓冲区
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = raf.read(flush))) {
				if(actualBlockSize - len >= 0) {  //查看是否足够
					//写出
					bos.write(flush, 0, len);
					actualBlockSize -= len;  //剩余量
					
				}else {  //写出最后一次的剩余量
					bos.write(flush, 0, (int) actualBlockSize);
					break;
				}
		
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			FileUtil.close(bos, raf);
		}
		

	}
	
	public void mergeFile(String destPath) throws IOException {
		//创建源
		File dest = new File(destPath);
		//选择流
		BufferedOutputStream bos = null;  //输出流
		SequenceInputStream sis = null;   //输入流
		//创建一个容器
		Vector<InputStream> vi = new Vector<InputStream>();
		for(int i = 0; i < this.blockPath.size(); i++) {
			vi.add(new BufferedInputStream(
					new FileInputStream(
							new File(this.blockPath.get(i)))));
		}
		
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest, true));   //追加
			sis = new SequenceInputStream(vi.elements());  //将多个流合并为一个流
			BufferedInputStream bis = null;
			for(int i = 0; i < this.blockPath.size(); i++) {
					bis = new BufferedInputStream(
					new FileInputStream(
							new File(this.blockPath.get(i)))
					);
					
					//缓冲区
					byte[] flush = new byte[1024];
					//接收长度
					int len = 0;
					while(-1 != (len = sis.read(flush))) {
						bos.write(flush, 0, len);
					}
					bos.flush();
					FileUtil.close(sis);
					
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			FileUtil.close(bos);
		}
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {
		SplitFile split  =new SplitFile("E:/IO/test/demo02.java", 200, "e:/IO");  //指定的字节数

//		System.out.println(split.size);
		
//		split.split("e:/IO");
		
		split.mergeFile("e:/IO/test1.java");
	}

}
