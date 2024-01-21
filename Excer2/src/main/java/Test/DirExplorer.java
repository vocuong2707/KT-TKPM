package Test;

import java.io.File;

import Test.DirExplorer.FileHandler;
import Test.DirExplorer.Filter;

public class DirExplorer {
	public interface FileHandler {
		void handle(int level, String path, File file);

	}

	public interface Filter {
		boolean interested(int level, String path, File file);
	}

	private FileHandler fileHandler;
	private Filter filter;

	public DirExplorer(Filter filter, FileHandler fileHandler) {
		this.filter = filter;
		this.fileHandler = fileHandler;
	}

	public void explore(File root) {
		explore(0, "", root);
	}

	private void explore(int level, String path, File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				explore(level + 1, path + "/" + child.getName(), child);
			}
		} else {
			if (filter.interested(level, path, file)) {
				fileHandler.handle(level, path, file);
			}
		}
	}
	void test_old_style() {
		File projectDir = new File("C:\\Users\\Student\\eclipse-workspace\\Excer2\\src\\main\\java\\Exception");
		DirExplorer.Filter filter = new Filter() {
			public boolean interested(int level, String path, File file) {
				return path.endsWith(".java");
			}
		};
		DirExplorer.FileHandler handler = new FileHandler() {
			
			public void handle(int level, String path, File file) {
				System.out.println(path);
			}
		};
		DirExplorer di = new DirExplorer(filter, handler);
		di.explore(projectDir);
	}
	
	
	public static void main(String[] args) {
		File projectDir = new File("C:\\Users\\Student\\eclipse-workspace\\Excer2\\src\\main\\java\\Exception");
		new  DirExplorer((level,  path,  file)  ->  path.endsWith(".java"),  (level,  path, 
		file) -> {
		System.out.println(file.getName());
		}).explore(projectDir);
		}
	}

