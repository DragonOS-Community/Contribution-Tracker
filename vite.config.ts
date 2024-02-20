import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// 自动导入Element Plus
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";

// Element自动导入 图标
import Icons from 'unplugin-icons/vite'
import IconsResolver from 'unplugin-icons/resolver'

import { resolve } from "path";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [
      vue(),
      // 自动导入Element Plus
      AutoImport({
        resolvers: [ElementPlusResolver()],
      }),
      Components({
          resolvers: [
              IconsResolver({
                  // 修改Icon组件前缀，不设置则默认为i,禁用则设置为false
                  prefix: 'icon',
                  // 指定collection，即指定为elementplus图标集ep
                  enabledCollections: ['ep']
              }),
              ElementPlusResolver()
          ],
      }),
      Icons({
          autoInstall: true
      })
    ],
    resolve: {
        alias: {
          "@": resolve(__dirname, "src") // 相对路径别名配置，使用 @ 代替 src
        }
    },
    base: "./", // 设置打包路径
    server: {
        port: 8083,
        open: true,
        cors: true,
        //设置代理，根据我们项目实际情况配置
        proxy: {
          '/api': {
            target: 'http://xxx.xxx.xxx.xxx:8000',
            changeOrigin: true,
            secure: false,
          }
        }
    },
})
