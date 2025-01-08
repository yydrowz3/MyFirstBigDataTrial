### Executing

1. change the `path` in `XXXDriver.class`

```
        // Set the input and output path
        FileInputFormat.setInputPaths(job, new Path("G:\\data\\input"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\data\\output"));
        //FileInputFormat.setInputPaths(job, new Path(args[0]));
        //FileOutputFormat.setOutputPath(job, new Path(args[1]));

```

2. execute from `main`

