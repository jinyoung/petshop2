<template>
    <div></div>
</template>

<script>
    const BaseRepository = require('../../repository/BaseRepository');
    const axios = require('axios').default;

    export default{
        name: 'BaseUIChart',
        data: () => ({
            path: "",
            repository: null,
            value: [],
            options: null,
            series: null,
            labels: [],
            data: [],
            categories: [],
        }),
        created() {
            this.repository = new BaseRepository(axios, this.path)
        },
        methods: {
            getValue() {
                this.value = this.repository.find();
            }
            setValue(chartType) {
                if (chartType === "pie") {
                    if(this.value && this.value.length > 0) {
                        this.value.forEach((item) => {
                            if (item) {
                                if (labels && labels.length > 0) {
                                    labels.forEach((label) => {
                                        if (item[label]) {
                                            this.options.labels.push(item[label]);
                                        }
                                    })
                                }
                                if (data && data.length > 0) {
                                    data.forEach((val) => {
                                        if (item[val]) {
                                            this.series.push(item[data]);
                                        }
                                    })
                                }
                            }
                        });
                    }
                } else {
                    if(this.value && this.value.length > 0) {
                        this.value.forEach((item) => {
                            if (item) {
                                if (categories && categories.length > 0) {
                                    categories.forEach((category) => {
                                        if (item[category]) {
                                            this.options.xaxis.categories.push(item[category]);
                                        }
                                    })
                                }
                                if (data && data.length > 0) {
                                    data.forEach((val) => {
                                        if (item[val]) {
                                            this.series[0].data.push(item[data]);
                                        }
                                    })
                                }
                            }
                        });
                    }
                }
            }
        },
    }
</script>
