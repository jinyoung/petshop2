<template>
    <div></div>
</template>

<script>
    const BaseRepository = require('../../repository/BaseRepository');
    const axios = require('axios').default;

    export default{
        name: 'BaseUIGrid',
        data: () => ({
            path: "",
            repository: null,
            value: [],
        }),
        created() {
            this.repository = new BaseRepository(axios, this.path)
        },
        methods: {
            getValue() {
                this.value = this.repository.find();
            }
        },
    }
</script>
