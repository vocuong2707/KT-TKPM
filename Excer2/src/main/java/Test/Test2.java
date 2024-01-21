package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class Test2 {
	public static void main(String[] args) throws Exception {
		ParseResult<CompilationUnit> parseResult = null;
		FileInputStream in = new FileInputStream("C:\\Users\\Student\\eclipse-workspace\\Excer2\\src\\main\\java\\Exception\\Bai1.java");
		
		try {
			JavaParser parser = new JavaParser();
			parseResult = parser.parse(in);
			Optional<CompilationUnit> optional = parseResult.getResult();
			if(optional.isPresent()) {
				CompilationUnit cu = optional.get();
				getFields(cu);
				getMethods(cu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			in.close();
		}
		
	}
		void x(String folederName) {
			File folder = new File(folederName);
			File[] files = folder.listFiles();
			for(File file : files) {
				System.out.println(file.getAbsolutePath());
			}
		}
	private static void getMethods(CompilationUnit cu) {
		// TODO Auto-generated method stub
		List<MethodDeclaration> fields = cu.findAll(MethodDeclaration.class);
		for(MethodDeclaration fieldDeclaration : fields) {
			System.out.println(fieldDeclaration);
		}
	}

	public static void getFields(CompilationUnit cu) {
		List<FieldDeclaration> fields = cu.findAll(FieldDeclaration.class);
		for(FieldDeclaration fieldDeclaration : fields) {
			System.out.println(fieldDeclaration);
		}
	}
}
