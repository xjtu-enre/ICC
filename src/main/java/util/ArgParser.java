package util;

import java.io.File;

public class ArgParser {
    public static final String DEFAULT_OUTPUT_FILE = "%s-enre-out/%s.icc.json";
    public static final String GRAPH_TYPE_UNIT = "Unit";
    public static final String GRAPH_TYPE_BLOCK = "Block";

    private static boolean isFile(String filepath) {
        File f = new File(filepath);
        return f.isFile();
    }

    private static boolean isDirectory(String path) {
        File f = new File(path);
        return f.isDirectory();
    }

    private static void help() {
        System.out.println("test");
    }

    public static Args parseArgs(String[] args) {
        Args res = new Args();
        int index = 0;
        while (index < args.length) {
            String cur = args[index];
            switch (cur) {
                case "-h":
                case "--help":
                    help();
                    System.exit(0);
                case "-p":
                case "--projectPath":
                    res.projectPath = args[index + 1];
                    break;
                case "-n":
                case "--projectName":
                    res.projectName = args[index + 1];
                    break;
                case "-t":
                case "--type":
                    res.type = args[index + 1];
                    break;
                case "-i":
                case "--enreJson":
                    res.enreJson = args[index + 1];
                    break;
                case "-o":
                case "--outputJson":
                    res.outputJson = args[index + 1];
                    break;
                case "-name": //apk名字
                    res.name = args[index + 1];
                    break;
                case "-outputDir": //icc输出路径
                    res.outputDir = args[index + 1];
                    break;
                case  "-path": //apk文件路径
                    res.path = args[index + 1];
                    break;
                default:
                    throw new RuntimeException("no such option: " + cur);
            }
            index += 2;
        }

        if (res.getProjectPath() == null) {
            throw new RuntimeException("option 'projectPath' must be specified.");
        }
        if (res.getProjectName() == null) {
            throw new RuntimeException("option 'projectName' must be specified.");
        }
        if (res.getType() != null &&
                (!res.getType().equals(GRAPH_TYPE_UNIT) && !res.getType().equals(GRAPH_TYPE_BLOCK))) {
            throw new RuntimeException(String.format(
                    "option 'type' must be '%s' or '%s'!",
                    GRAPH_TYPE_UNIT,
                    GRAPH_TYPE_BLOCK));
        }
        if (res.getType() == null) {
            res.setType("Unit");
        }
        if (res.getEnreJson() == null) {
            throw new RuntimeException("option 'enreJson' must be specified.");
        }
        if (res.getOutputJson() == null) {
            res.setOutputJson(String.format(DEFAULT_OUTPUT_FILE, res.getProjectName(), res.getProjectName()));
        }
        //res.outputJson = res.outputDir + '\\' + res.outputJson;
       // res.enreJson = res.outputDir + '\\' + res.enreJson;
        File projectPathFile = new File(res.projectPath);
        File enreJsonFile = new File(res.enreJson);
        File outputJsonFile = new File(res.outputJson);
        if (!projectPathFile.isDirectory()) {
            throw new RuntimeException("invalid argument 'projectPath': " + res.projectPath);
        }
        if (!enreJsonFile.isFile() || !res.enreJson.endsWith(".json")) {
            throw new RuntimeException("invalid argument 'enreJson': " + res.enreJson);
        }
        if (!outputJsonFile.isFile()) {
            if (outputJsonFile.getParentFile() != null && !outputJsonFile.getParentFile().exists() && !outputJsonFile.getParentFile().mkdirs()) {
                throw new RuntimeException("build output file failed");
            }
        }
        return res;
    }

    public static class Args {
        private String projectPath;
        private String projectName;

        private String name;
        private String enreJson;
        private String outputJson;
        private String type;

        private String outputDir;

        private String path;

        public Args() {
        }

        public Args(String projectPath, String projectName, String enreJson, String outputJson) {
            this.projectPath = projectPath;
            this.projectName = projectName;
            this.enreJson = enreJson;
            this.outputJson = outputJson;
        }

        public String getOutputJson() {
            return outputJson;
        }

        public void setOutputJson(String outputJson) {
            this.outputJson = outputJson;
        }

        public String getProjectPath() {
            return projectPath;
        }

        public void setProjectPath(String projectPath) {
            this.projectPath = projectPath;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getEnreJson() {
            return enreJson;
        }

        public void setEnreJson(String enreJson) {
            this.enreJson = enreJson;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


        public String getOutputDir() {
            return outputDir;
        }

        public void setOutputDir(String outputDir) {
            this.outputDir = outputDir;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Args{" +
                    "projectPath='" + projectPath + '\'' +
                    ", projectName='" + projectName + '\'' +
                    ", enreJson='" + enreJson + '\'' +
                    ", outputJson='" + outputJson + '\'' +
                    '}';
        }
    }
}

