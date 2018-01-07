module.exports = function() {
    var config = {
        paths: {
            js: [
                './src/**/*.js',
                './*.js'
            ],
            css: [
                './src/**/*.css',
            ],
            beautify: [
                './*',
                './src/*'
            ]
        }
    };
    return config;
};