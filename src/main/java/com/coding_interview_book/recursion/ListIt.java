package com.coding_interview_book.recursion;

import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ListIt {
//    public static void main ( String args[] ) throws Exception {
//
//        FileSystem fs = FileSystems.getDefault();
//        Path path = fs.getPath(args[0]);
//
//        if ( !Files.exists(path) || !Files.isReadable(path)) {
//            System.out.println( "Can't read " + path);
//            return;
//        }
//
//        if ( Files.isDirectory(path) ) {
////            String [] files = path.list();
////            for ( String aFile : files )
////                System.out.println( aFile );
//        } else
//            try {
//                BufferedReader in;
//                try (Reader ir = new InputStreamReader(
//                        new FileInputStream(path))) {
//
//                    in = new BufferedReader(ir);
//                }
//                String line;
//                while ((line = in.readLine()) != null)
//                    System.out.println(line);
//            }
//            catch ( FileNotFoundException e ) {
//                System.out.println( "File Disappeared" );
//            }
//    }

    public static void main(String[] args) {
        System.out.println(convertToBinary("A", "UTF-32"));
    }

    static String convertToBinary(String input, String encoding) {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();

        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e & 255))
                .map(e -> String.format("%8s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }
}