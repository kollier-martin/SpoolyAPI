const path = require('path');

module.exports = {
    entry: "./src/app.js",
    devServer: {
        server: {
            type: 'https',
            options: {

            }
        },
        static: {
            directory: path.join(__dirname, 'src'),
        },
        compress: true,
        port: 3000,
    },

    output: {
        filename: 'my-first-webpack.bundle.js',
    },

    mode: 'development',

    module: {
        rules: [
            {   test: /\.js$|jsx$/,
                loader: 'raw-loader',
                exclude: path.join(__dirname, 'node_modules')
            }],
    },
};